package com.hadi.maydapp.data

import com.google.gson.Gson
import com.hadi.maydapp.data.datasource.remotedatasource.ServiceApi
import com.hadi.maydapp.data.mappers.DataLayerLinksesMapper
import com.hadi.maydapp.data.repository.RepositoryImplementer
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@RunWith(JUnit4::class)
class ServerResponseTest {
    private val server: MockWebServer = MockWebServer()
    private val MOCK_WEBSERVER_PORT = 8000

    lateinit var serviceApi: ServiceApi
    lateinit var repositoryImplementer: RepositoryImplementer
    lateinit var fakeJsonResponse: String

    var dataLayerVehicleDataMapper = DataLayerLinksesMapper()


    @Before
    fun init() {
        server.start(MOCK_WEBSERVER_PORT)

        serviceApi = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ServiceApi::class.java)

        dataLayerVehicleDataMapper = DataLayerLinksesMapper()

        repositoryImplementer = RepositoryImplementer(serviceApi, dataLayerVehicleDataMapper)

        fakeJsonResponse = "{\n" +
                "    \"ok\": true,\n" +
                "    \"result\": {\n" +
                "        \"code\": \"DrpLId\",\n" +
                "        \"short_link\": \"shrtco.de\\/DrpLId\",\n" +
                "        \"full_short_link\": \"https:\\/\\/shrtco.de\\/DrpLId\",\n" +
                "        \"short_link2\": \"9qr.de\\/DrpLId\",\n" +
                "        \"full_short_link2\": \"https:\\/\\/9qr.de\\/DrpLId\",\n" +
                "        \"short_link3\": \"shiny.link\\/DrpLId\",\n" +
                "        \"full_short_link3\": \"https:\\/\\/shiny.link\\/DrpLId\",\n" +
                "        \"share_link\": \"shrtco.de\\/share\\/DrpLId\",\n" +
                "        \"full_share_link\": \"https:\\/\\/shrtco.de\\/share\\/DrpLId\",\n" +
                "        \"original_link\": \"https:\\/\\/www.youtube.com\\/watch?v=HW2A98153Oo&t=6758s\"\n" +
                "    }\n" +
                "}"


    }

    @After
    fun shutdown() {
        server.shutdown()
    }

    @Test
    fun `JsonPlaceholder APIs parse correctly`() {
        server.apply {
            enqueue(MockResponse().setBody(fakeJsonResponse))
        }
        repositoryImplementer.getShortUrl("https://www.youtube.com/watch?v=HW2A98153Oo&t=6758s")
            .test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertComplete()
            .assertValueCount(1)
            .assertValue { it.code != null }
            .assertValue { it.short_link != null }
            .assertValue { it.full_share_link != null }
            .assertValue { it.share_link != null }
            .assertValue { it.original_link != null }
            .assertNoErrors()
    }





}