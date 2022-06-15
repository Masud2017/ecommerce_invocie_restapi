#!/usr/bin/bash

cmake -S . -B build
cmake --build build

build/nativePdfGenerator
