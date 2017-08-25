package com.example.administrator.rxjavademo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bean.Student;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "mrgao";
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView text_view;
    private StringBuffer stringBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        text_view = (TextView) findViewById(R.id.text_view);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        stringBuffer = new StringBuffer();

/*        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                Utils.checkNotMain();
                e.onNext(3);
                e.onComplete();
                e.onNext(4);
                e.onNext(5);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(TAG,"integer:"+integer);
            }
    });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Observable.just(1, 2, 3, 4)
                        .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                        .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
                        .subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer number) {
                                Log.e(TAG, "number:" + number);
                                stringBuffer.append(","+number);
                                text_view.setText("Integer"+stringBuffer);
                                Toast.makeText(MainActivity.this,"stringBuffer:"+stringBuffer,Toast.LENGTH_LONG).show();
                            }
                        });
                break;
            case R.id.button2:
                Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        subscriber.onNext(1);
                        subscriber.onNext(2);
                        subscriber.onNext(3);
                        subscriber.onCompleted();
                        subscriber.onNext(4);
                    }
                }).subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        stringBuffer.append(",onCompleted");
                        text_view.setText("Text:"+stringBuffer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        text_view.setText("throwable"+throwable);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        stringBuffer.append(","+integer);
                        text_view.setText("integer"+stringBuffer);
                    }
                });
                break;
            case R.id.button3:
                Student[] students = new Student[]{};
                Subscriber<String> subscriber = new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onNext(String name) {
                        Log.e(TAG, name);
                    }
                };
                Observable.from(students)
                        .map(new Func1<Student, String>() {
                            @Override
                            public String call(Student student) {
                                return student.getName();
                            }
                        }).subscribe((Action1<? super Object>) subscriber);
                break;
            case R.id.button4:
                break;
        }
    }
}
