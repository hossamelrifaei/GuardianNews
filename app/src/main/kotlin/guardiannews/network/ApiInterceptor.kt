package guardiannews.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api-key", "6531f5a0-6b01-4798-96eb-ecda9cff60a0")
                .addQueryParameter("show-fields", "thumbnail,bodyText")
                .build()

        val requestBuilder = original.newBuilder()
                .url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
