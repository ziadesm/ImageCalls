package android.com.imagecalls.interfaces;

import android.com.imagecalls.pojo.ModelImage;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiConfig {
    @GET("photos")
    Single<List<ModelImage>> getImage();
}
