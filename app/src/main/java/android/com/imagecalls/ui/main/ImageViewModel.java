package android.com.imagecalls.ui.main;

import android.com.imagecalls.interfaces.ImageClient;
import android.com.imagecalls.pojo.ModelImage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ImageViewModel extends ViewModel {
    private static final String TAG = "ImageViewModel";
    MutableLiveData<List<ModelImage>> mutableLiveData = new MutableLiveData<>();

    public void getImage() {
        Single<List<ModelImage>> observable = ImageClient.getInstance().getImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(c-> mutableLiveData.setValue(c));
    }
}
