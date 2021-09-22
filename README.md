<p align="center">
 <img src = "src/img/githubImage.png" alt = "Screenshot of a 2D rhythm game" style="width:500px;height:300px;"/>
</p>

<p align="center">
 <strong>This is open source rhythm game using Java.</strong>
</p>

## Getting Started
### Building and installing

#### Prereqs:
- [JLayer](https://jar-download.com/artifacts/javazoom) to enable support for playing game music
- [Visual Studio 2019+](https://visualstudio.microsoft.com/en/downloads) to enable support for build
- A java compiler (Java 15.0.1+)

<p> After downloading and extracting a source, Clone the repository.</p>
    
    git clone https://github.com/cshim31/Visual-Sound.git
  
<p> Build the visual sound. </p> 

    cmake -DJLAYER_JAR="" .
    cmake --build . [--config Release]
    
<p> Run the visual sound </p>
 
    java -jar VisualSound.jar
    

## System
### What does a checkmark mean?

</p>When an item is checkmarked, it means the implementation is complete. Uncheckmarked means implementation is planned in future. 

#### Features
 - [x] Flexible screen switching
 - [x] Beat combo and score feature
 - [x] Optimized beat tapping judgement
 - [x] Refine game screen and components
 - [ ] Player Health 

#### Bugs
 - [ ] Bug: Beat node disappearing when key is pressed early before node hits keypad
 - [ ] Bug: Music playing bad quality at special case
