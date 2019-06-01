# gifToAscIIGif
将GIF动态图转化成网红AscII码流动态图

原图是KUNKUN.gif，
转为ASCII码流动态图图是：success-KUNKUN.gif

### 转换原理
将Gif文件通过ImageInputStream读取图像信息流，再用ImageReader对图像经行解码，将图像一帧一帧存入BufferedImage[]，根据图像的大小建立比例的Graphics图样
```
g.setColor(Color.WHITE);
g.fillRect(0, 0, oneCharImg.getWidth(), oneCharImg.getHeight());
g.setColor(Color.BLACK);
g.setFont(new Font("黑体", Font.BOLD, 15));
```
再更具图像的像素，以4个像素为一个点算出该点的平均RGB深度，更具平均RGB颜色深度在一下Ascii符号中经行选择
```
private static String[] chars= {" ",".",":",";","-","~","1","i","o","r","a",
"2","c","3","b","n","q","k","x","S","X",
"7","Z","O","8","#","$","%","&","M","B",
"W","@","@"};
```
完成图样的绘画后将图样存入charImgs[]，然后将整个 charImgs[]用AnimatedGifEncoder 经行图像转化为Gif动态图

转化一张6M的Gif图转化大概需要1分钟左右

希望有兴趣的大佬能帮助优化优化
