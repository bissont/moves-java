package me.pims.moves.client;

import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.JacksonConverter;

import static com.google.common.base.Preconditions.checkNotNull;

public class MovesBuilder {

    class SimpleErrorHandler implements ErrorHandler {
        @Override
        public Throwable handleError(RetrofitError cause) {
            final Response r = cause.getResponse();
            if (r != null) {
                System.out.println(r.getStatus());
                System.out.println(r.getUrl());
                System.out.println(r.getReason());
            }
            return cause;
        }
    }

    final RequestInterceptor requestInterceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestInterceptor.RequestFacade request) {
            request.addHeader("Authorization", String.format("Bearer %s", token));
        }
    };

    private String endpoint;
    private ErrorHandler errorHandler;
    private String token;

    public MovesBuilder() {
        this.endpoint = "https://api.moves-app.com/api/1.1";
        this.errorHandler = new SimpleErrorHandler();
    }

    public MovesBuilder setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public MovesBuilder setErrorHandler(final ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
        return this;
    }

    public MovesBuilder setToken(final String token) {
        this.token = token;
        return this;
    }

    public Moves build() {
        checkNotNull(endpoint, "Endpoint can not be null");
        checkNotNull(token, "OAuth token can not be null");

        final RestAdapter adapter = new RestAdapter.Builder()
                .setConverter(new JacksonConverter())
                .setEndpoint(endpoint)
                .setErrorHandler(errorHandler)
                .setRequestInterceptor(requestInterceptor)
                .build();

        return adapter.create(Moves.class);
    }
}
