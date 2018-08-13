# Android学习笔记：搭建环境

##IDE
Android Stdio 是现在安卓主流的开发环境，[官网下载](http://developer.android.google.cn)需要科学上网，安装过程很简单基本上一直next即可。一开始使用就发现AS很吃内存，没用多久我的C盘就红了，实践证明按[这篇文章](https://www.jianshu.com/p/2d99644007da)操作可以有效解决问题。

##工程文件
项目结构模式切换到project后，可以看最主要的文件都在app/src目录下：
1.java：java源代码
2.res：资源文件，包括图片，布局，字符串等
3.AndroidManifest.xml:
这是整个项目的配置文件，里面有应用程序的属性和权限声明，工程中所有组件要在这里注册，配置属性。
其他文件个人理解目前用不到，不作赘述。

##日志工具Log
Android提供了专门的日志工具类Log（Android.util.Log),这个类提供了级别由低到高以下五中种方法：
Log.v() --- verbose
Log.d() --- debug
Log.i() --- info
Log.w() --- warn
Log.e() --- error

以debug为例 Log.d(tag,msg) 第一个参数是标签，一般传入当前类名，第二个参数是message即打印内容。

Log类配合IDE的logcat，可以方便地对日志进行过滤和查询。

##几个快捷键
Ctrl+/ :            注释选中代码
Ctrl+Shift+/ :   以/**/方式注释
Tab或Enter： 代码补全（超方便）
在onCreat方法外输入logt然后按下Tab键可自动生成一个TAG常量。