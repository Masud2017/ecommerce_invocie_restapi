cmake_minimum_required(VERSION 3.10)

# set the project name
project(nativePdfGenerator VERSION 1.0)


set (NATIVE_SRCS src/test.cpp)


add_executable(${PROJECT_NAME} main.cpp ${NATIVE_SRCS})

include_directories (/usr/include/freetype2)

include(ExternalProject)

# add_external(podofo_new/podf-build/podof)


add_subdirectory(lib/spdlog)
# add_subdirectory(lib/podofo/)
# add_subdirectory(podofo_new/podof-build/podofo)

SET(PODOFO_BUILD_LIB_ONLY:BOOL TRUE)


# find_library(podofo REQUIRED)
# find_library(boost REQUIRED)
target_include_directories(${PROJECT_NAME} PUBLIC include 
    PUBLIC lib/spdlog/include
)

target_link_directories(${PROJECT_NAME} 
	PRIVATE lib/spdlog/src
)

# set_property(TARGET ${PROJECT_NAME}
#     PROPERTY VS_PACKAGE_REFERENCES "CodePorting.Native.Cs2Cpp.API.22.5.0"
# )


target_link_libraries(${PROJECT_NAME}  spdlog)


