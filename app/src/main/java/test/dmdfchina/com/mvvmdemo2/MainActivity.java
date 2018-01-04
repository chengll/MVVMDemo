package test.dmdfchina.com.mvvmdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SecondAdapter<UserInfoBean> adapter;
    private List<UserInfoBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.setName("哈密" + i);
            userInfoBean.setAge(i);
            userInfoBean.setImgUrl("http://img.bimg.126.net/photo/DCi7Q__VN3NJ_63cq7sosA==/3439905690381537164.jpg");
            mList.add(userInfoBean);
        }
        adapter=new SecondAdapter<>(mList,BR.userInfo,BR.userImage,R.layout.layout_one_user,R.layout.second_layout);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }
}
