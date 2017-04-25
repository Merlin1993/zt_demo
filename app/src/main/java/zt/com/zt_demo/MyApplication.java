package zt.com.zt_demo; /**
 *
 */

import android.app.Application;
import android.os.Looper;

import com.bumptech.glide.Glide;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MyApplication extends Application {


	private static MyApplication instance;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		ZXingLibrary.initDisplayOpinion(this);

	}

	// 单例模式中获取唯一的MyApplication实例
	public static MyApplication getInstance() {
		if (null == instance) {
			instance = new MyApplication();
		}
		return instance;

	}

	public void exit() {
		clearCacheDiskSelf();
		clearCacheMemory();
		System.exit(0);
	}

	public boolean clearCacheDiskSelf() {
		try {
			if (Looper.myLooper() == Looper.getMainLooper()) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						Glide.get(MyApplication.getInstance()).clearMemory();
					}
				}).start();
			} else {
				Glide.get(MyApplication.getInstance()).clearMemory();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 清除Glide内存缓存
	public boolean clearCacheMemory() {
		try {
			if (Looper.myLooper() == Looper.getMainLooper()) { // 只能在主线程执行
				Glide.get(MyApplication.getInstance()).clearMemory();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
