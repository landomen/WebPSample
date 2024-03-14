# Android WebP Image Loading Sample

This sample app demonstrates different aspects of working with WebP Image format on Android and allows comparing image quality and load times between PNG/JPG and WebP.

It is meant as a companion to the **[Optimizing Android App Size By Leveraging the WebP Image Format](https://medium.com/@domen.lanisnik/optimizing-android-app-size-by-leveraging-the-webp-image-format-87189f8c7603)** blog post.

Included are the following functionalities:
 - Compare image quality and file size differences between original PNG image, losslessly converted WebP image and lossy converted WebP image
 - Compare image quality and file size differences between JPG and converted WebP images
   - Supports zooming images to view more details
 - View how to load WebP images in Compose from a URL using Coil or Glide
 - Benchmark image loading times between JPG and WebP image 

The project contains all the PNG, JPG and WebP images. WebP images were converted from the original 100% quality PNG and JPG image. JPG images with different quality were compressed using [ImageMagick](https://imagemagick.org/index.php).

You can download the source code and build the app yourself or download the prepared APK file.

**Previews**

<p float="left">
  <img src="/previews/preview1_intro.png" width="19%" />
  <img src="/previews/preview2_png.png" width="19%" /> 
  <img src="/previews/preview3_jpg.png" width="19%" />
  <img src="/previews/preview4_jpg.png" width="19%" />
  <img src="/previews/preview5_remote.png" width="19%" />
  <img src="/previews/preview6_benchmark.png" width="19%" />
  <img src="/previews/preview7_benchmark.png" width="19%" />
</p>
