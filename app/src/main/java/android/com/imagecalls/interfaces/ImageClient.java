package android.com.imagecalls.interfaces;

import android.com.imagecalls.pojo.ModelImage;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private ApiConfig apiConfig;
    private static ImageClient INSTANCE;

    private ImageClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        apiConfig = retrofit.create(ApiConfig.class);
    }

    public static ImageClient getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new ImageClient();
        }
        return INSTANCE;
    }

    public Single<List<ModelImage>> getImages() {
        return apiConfig.getImage();
    }
}
