# Android学习笔记：搭建环境

## IDE
Android Stdio 是现在安卓主流的开发环境，[官网下载](http://developer.android.google.cn)需要科学上网，安装过程很简单基本上一直next即可。一开始使用就发现AS很吃内存，没用多久我的C盘就红了，实践证明按[这篇文章](https://www.jianshu.com/p/2d99644007da)操作可以有效解决问题。

## 工程文件
项目结构模式切换到project后，可以看最主要的文件都在app/src目录下：
1.java：java源代码
2.res：资源文件，包括图片，布局，字符串等
3.AndroidManifest.xml:
这是整个项目的配置文件，里面有应用程序的属性和权限声明，工程中所有组件要在这里注册，配置属性。
其他文件个人理解目前用不到，不作赘述。

## 日志工具Log
Android提供了专门的日志工具类Log（Android.util.Log),这个类提供了级别由低到高以下五中种方法：
Log.v() --- verbose
Log.d() --- debug
Log.i() --- info
Log.w() --- warn
Log.e() --- error

以debug为例 Log.d(tag,msg) 第一个参数是标签，一般传入当前类名，第二个参数是message即打印内容。

Log类配合IDE的logcat，可以方便地对日志进行过滤和查询。

## 几个快捷键
Ctrl+/ :            注释选中代码
Ctrl+Shift+/ :   以/**/方式注释
Tab或Enter： 代码补全（超方便）
在onCreat方法外输入logt然后按下Tab键可自动生成一个TAG常量。



# Android学习笔记二：Activity & Layout

## 一些理解
直观来看Activity就是我们手机中看到的一个一个的页面，页面中的内容就是布局，布局内放置各种控件。多组页面以返回栈放方式存放，类似堆栈后进先出。一个堆栈即一个任务，只有栈顶的页面处于运行状态。一个app可以存在多个返回栈，即多任务。（个人理解欢迎纠正）

## 活动（Activity）的周期
每个新建一个活动都要在AndroidManifest文件中注册（AS会自动完成）。

活动存在四种状态，对应于其在栈中的不同位置：
运行状态：活动处栈顶时；
暂停状态：活动不处于栈顶，但可见时；
停止状态：活动不可见时；
销毁状态：活动出栈时。

活动的生命周期包含7个回调方法，在不同的状态时自动调用：
![活动的生命周期](https://upload-images.jianshu.io/upload_images/24168-ac3c0ae02a9efe91.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## Intent
活动之间的切换和数据传递需要借助Intent，具体用法为```new```一个Intent实例，并以各种方式（显式或隐式）指定下一个活动，使用Intent的```putExtra()```方法,将要传递的数据放入Intent，然后调用```startActivity()```或```startActivityForResult()```方法传入Intent实现跳转。Intent甚至可以跳转到其他app的活动中，实现应用间功能共享。

## Layout
Android讲究逻辑和布局的分离，每一个活动最好对应一个布局。布局文件写在res文件夹的xml文件中，并在java中以```R.Layout.文件名```的方式调用。常用的四种布局有LinerLayout，RelativeLayout，FrameLayout，PercentLayout。布局标签内定义各种控件，每个控件要命名一个ID，在java中以 ```R.id.命名```方式调用。

## 书中未提到的
##### Layout预览
新版的AS似乎无法直接预览Layout文件，这给编辑布局文件带来不少麻烦，解决方法参考[此文](https://blog.csdn.net/weixue9/article/details/78355571)；

##### 注册监听器
书中介绍了两种监听器的注册方法，一种为匿名类方式，对于java不太熟练的我来说语法有些怪异，另一种为实现接口的方式，不知为何实际无法实现，后参考[此文](https://blog.csdn.net/kyi_zhu123/article/details/52601691)采用了第四种方式实现。

##### 例程
关于控件，内容过于繁杂，在此不做赘述，练习代码在[我的git仓库](https://github.com/OldQiang/AndroidLearn)持续更新。

