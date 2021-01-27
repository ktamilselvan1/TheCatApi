# TheCatApi

Implemented a Library module to handle the image list. The images will be retrieved from "TheCatApi.com".

The library module will expose only one method to show the Image listing page, and the library activity will receive the action and will start activity to show 
endless scrollable Cat images.

Domain module consists of the base abstract items, such as Repository interfaces, Usecase and Model entity.

Data module consists of implementaion of the Repository with Retrofit.

The ImagePicker library module will take care of the activity with a fragment to show list of cat images and will return the URL of selected image.

The Toolbar can be customized by setting below values,

    <color name="toolbar_color">#FF6200EE</color> -> To update the toolbar_color
    <color name="toolbar_back_icon_color">#FFFFFF</color> -> To update the back icon color
    
    <string name="lib_title">Choose Image</string> -> To update the library module image listing page title.

