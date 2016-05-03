flashview
=========

首页广告位轮播，用于应用程序首页的轮播图，如下图所展示：

 ![image] (https://github.com/gcgongchao/flashview/raw/master/images/flashviewgit20150128.gif)
 
使用此library时实现上图中的轮播效果时，分为以下两步骤: <br/>
（1）在布局文件中加入如下代码块：<br/>
      
      <com.gc.flashview.FlashView
        android:id="@+id/flash_view"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        android:layout_margin="10dp"
        app:effect="cube"  
        />
（2）在Activity或Fragment中，想如下那样使用该控件：<br/>

        flashView=(FlashView)findViewById(R.id.flash_view);
        imageUrls=new ArrayList<String>();
        imageUrls.add("http://www.qipaox.com/tupian/200810/20081051924582.jpg");
        imageUrls.add("http://www.bz55.com/uploads1/allimg/120312/1_120312100435_8.jpg");
        imageUrls.add("http://img3.iqilu.com/data/attachment/forum/201308/21/192654ai88zf6zaa60zddo.jpg");
        imageUrls.add("http://img2.pconline.com.cn/pconline/0706/19/1038447_34.jpg");<br/>
        imageUrls.add("http://www.kole8.com/desktop/desk_file-11/2/2/2012/11/2012113013552959.jpg");
        imageUrls.add("http://www.237.cc/uploads/pcline/712_0_1680x1050.jpg");
        flashView.setImageUris(imageUrls);
        flashView.setEffect(EffectConstants.CUBE_EFFECT);//更改图片切换的动画效果
        
此代码使用比较简单，后续我会加入轮播切换的效果，至于切换动画的一些类已经在里面了，下次更新时，将和自定义的控件一起使用。<br/>
（3）如果想对图片进行点击事件监听，可以在你的Activity或Fragment使用setOnPageClickListener，用法如下：<br/>

        
        
         
          flashView.setOnPageClickListener(new FlashViewListener() {
        	 @Override
        	 public void onClick(int position) {
        	 Toast.makeText(getApplicationContext(), "你的点击的是第"+(position+1)+"张图片！", 1000).show();
        	 }});
        	 
 或者如下使用：  
      
          
           flashView.setOnPageClickListener(new FlashViewListener(this); 
           @Override
           public void onClick(int position) {
           // TODO Auto-generated method stub
           Toast.makeText(getApplicationContext(), "你的点击的是第"+(position+1)+"张图片！", 1000).show();
           }
如把FlashView作为HeadView的时候，会有一个不会滚动的bug，按照如下方式修改FlashView即可：
	
		private void initUI(Context context) {
		imageViewsList = new ArrayList<ImageView>();
		dotViewsList = new ArrayList<ImageView>();
		imageUris = new ArrayList<String>();
		mBitmapLoader =new BitmapLoader(context);
		View view=LayoutInflater.from(context).inflate(R.layout.layout_slideshow, null);
		mLinearLayout = (LinearLayout) view.findViewById(R.id.linearlayout);
		mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
		/**
		 * 解决FlashView作为HeadView时的滑动冲突
		 */
		mViewPager.setOnTouchListener(new OnTouchListener() {
			 

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				PointF downP = new PointF();
			    PointF curP = new PointF();
			    int act = event.getAction();
			    if(act == MotionEvent.ACTION_DOWN || act == MotionEvent.ACTION_MOVE || act ==	    MotionEvent.ACTION_UP){
			     ((ViewGroup) v).requestDisallowInterceptTouchEvent(true);
			      if (downP.x == curP.x && downP.y == curP.y) {
			        return false;
			      }
			    }
			    return false;
			}
		});
		addView(view);
		
		// mFlashViewListener必须实例化

	}
如果在使用过程有任何bug，意见和指导，欢迎反馈与指导。本次加入的动画效果的代码来源于网络，在此感谢贡献此动画效果的作者。下次更新会尝试加入自己写的动画效果，欢迎star。
[楼主博客地址](http://blog.csdn.net/android_jiangjun/article/details/39638129)<br />（Android Studio版的Demo下载地址在这个链接的博文末尾）
