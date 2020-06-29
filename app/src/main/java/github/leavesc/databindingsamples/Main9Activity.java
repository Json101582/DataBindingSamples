package github.leavesc.databindingsamples;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;
import androidx.databinding.DataBindingUtil;
import github.leavesc.databindingsamples.databinding.ActivityMain9Binding;
import github.leavesc.databindingsamples.model.Image;

/**
 * 作者：CZY
 * 时间：2020/6/29 17:03
 * 描述：
 */
public class Main9Activity extends AppCompatActivity {

    private static final String TAG = "Main9Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main9);
        binding.setImage(new Image("xxxxxxx"));
        binding.setHandler(new Handler());
    }

    public class Handler {

        public void onClick(Image image) {
            image.getUrl().set("xxxxx" + new Random().nextInt(1000));
        }

    }

    @BindingAdapter({"url"})
    public static void loadImage(ImageView view, String url) {
        Log.e(TAG, "loadImage url : " + url);
    }

//    @BindingAdapter("android:text")
//    public static void setText(Button view, String text) {
//        view.setText(text + "-Button");
//    }
//
//    @BindingConversion
//    public static String conversionString(String text) {
//        return text + "-conversionString";
//    }

    @BindingConversion
    public static Drawable convertStringToDrawable(String str) {
        if (str.equals("红色")) {
            return new ColorDrawable(Color.parseColor("#FF4081"));
        }
        if (str.equals("蓝色")) {
            return new ColorDrawable(Color.parseColor("#3F51B5"));
        }
        return new ColorDrawable(Color.parseColor("#344567"));
    }

    @BindingConversion
    public static int convertStringToColor(String str) {
        if (str.equals("红色")) {
            return Color.parseColor("#FF4081");
        }
        if (str.equals("蓝色")) {
            return Color.parseColor("#3F51B5");
        }
        return Color.parseColor("#344567");
    }

}