package test.dmdfchina.com.mvvmdemo2;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import test.dmdfchina.com.mvvmdemo2.BR;

/**
 * Created by mkt on 2018/1/4.
 */

public class UserInfoBean  extends BaseObservable{
    private String name;
    private int age;
    private String imgUrl;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Bindable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /*定义加载图片的方法，注意一定静态的，其次一定要添加注解*/

    @BindingAdapter({"image"})
    public static void getImageFrom(ImageView imageView,String imgUrl){
        Glide.with(imageView.getContext()).load(imgUrl).into(imageView);
    }

    /*设置图片的点击事件*/
    public void getItemListener(View view){
        Toast.makeText(view.getContext(),"您点击了",Toast.LENGTH_SHORT).show();
        setName("玲玲宝贝");
    }
}
