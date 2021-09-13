cmake_minimum_required(VERSION 3.20.0)

find_package(Java 1.8 REQUIRED)

if(JAVA_FOUND)
	include(UseJava)
else() 
	message(WARNING "Couldn't find Java")
endif()

# serach for JLayer
find_jar(JLAYER_JAR "jlayer-1.0.1")
message("jlayer.jar is at ${JLAYER_JAR}")

enable_testing()

set(project VisualSound)

project(${project} NONE)

#set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.6" "-target" "1.6")

set(CMAKE_JAVA_INCLUDE_PATH ${PROJECT_SOURCE_DIR}/src)

add_jar(${project} 
	SOURCES
		${PROJECT_SOURCE_DIR}/src/main/Main.java 
	INCLUDE_JARS
		${JLAYER_JAR})

install_jar(${project} ${CMAKE_INSTALL_PREFIX})

get_target_property(_jarFile ${project} JAR_FILE)
get_target_property(_classDir ${project} CLASSDIR)

message(STATUS "Jar file ${_jarFile}")
message(STATUS "Class compiled to ${_classDir}")

add_test(NAME TestVisualSound COMMAND ${Java_JAVA_EXECUTABLE} -cp ${_jarFile} -jar ${project})

