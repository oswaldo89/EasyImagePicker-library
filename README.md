# EasyImagePicker


Libreria de facil implementacion, para Android nativo, se pueden obtener imagenes desde la galeria y desde la camara.

  - Se pueden agregar hasta 10 imagenes
  - Eliminar imagen despues agregarla
  - Visualizar imagen despues de agregarla
  - Posibilidad de cargar Imagenes desde una Url ( importante para cuando editas )
  - Para subir te devuelve un arreglo de Uri's para que las puedas manejar tu conveniencia.


You can also:
  - Import and save files from GitHub, Dropbox, Google Drive and One Drive
  - Drag and drop markdown and HTML files into Dillinger
  - Export documents as Markdown, HTML and PDF


![Imagen 1](https://extraimage.net/images/2017/04/14/aa9b794518197b108170ec31ce61e897.jpg)
![Imagen 2](https://extraimage.net/images/2017/04/14/6c6f3da27ce6bdb34592bae051bb9292.jpg)
![Imagen 3](https://extraimage.net/images/2017/04/14/2f96275ba2448f3bc442b6b9b090c668.jpg)

# Instalación

Agregamos las 2 url's del repositorio al build.gradle root

```java
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
        maven { url 'http://dl.bintray.com/raphaelbussa/maven' }
    }
}
```


Agregarmos la url de la dependencia al build.gradle del folder /app

```java
dependencies {
   compile 'com.github.oswaldo89:EasyImagePicker:1.0'
}
```


Agregamos el contenedor principal, las pruebas se hicieron dentro de un padre LinearLayout en orientación vertical.

```xml
<com.oswaldogh89.picker.ImagePicker
    android:id="@+id/picker"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

</com.oswaldogh89.picker.ImagePicker>
```

Dentro del activity en donde usaremos el control, instanciamos.
```java
ImagePicker picker = (ImagePicker) findViewById(R.id.picker);
picker.setMainactivity(ExampleUsage.this);
```

Podemos Agregar un color hexadecimal, para el contorno de las imagenes que se van agregando.
```java
picker.SetBorderImageColor("#075e55");
```

Podemos Habilitar/Inhabilitar el boton para borrar todas las imagenes, ( funcionalidad del boton no agregada )
```java
picker.enableDelateAll(false);
```

Por ultimo, para visualizar las imagenes hay que cacharlas una vez seleccionada desde la camara o la galeria, se hace con el siguiente codigo a la Activity en donde estamos trabajando.

```java
protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
    super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
    switch (requestCode) {
        case 0:
            if (resultCode == RESULT_OK) {
                picker.AddNewImage(imageReturnedIntent);
            }
            break;
        case 1:
            if (resultCode == RESULT_OK) {
                picker.AddNewImage(imageReturnedIntent);
            }
            break;
    }
}
```


Si estamos usando el control para una edicion de datos, y necesitamos que al inciar cargue unas urls, agregamos el siguiente codigo.

```java
//Si vas a cargar imagenes en el control desde una URL
ArrayList<String> urls = new ArrayList<>();
urls.add("https://static.independent.co.uk/s3fs-public/styles/article_small/public/thumbnails/image/2017/01/19/15/earth-from-space.jpg");
urls.add("http://www.slate.com/content/dam/slate/blogs/bad_astronomy/2016/03/09/shutterstock_earthfromhubble.jpg.CROP.original-original.jpg");
picker.addImagesFromUrl(urls);
```

Por ultimo , cuando ya quieras enviar las imagenes al servidor o guardarlas. las obtienes de la siguiente manera.
```java
HashMap<Integer, String> images = picker.GetPathImages();
for (Map.Entry entry : images.entrySet()) {
    Log.v("IMAGENES_AGREGADAS", "TAMAÑO : " + entry.getValue());
}

```
 
