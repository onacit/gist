#!/bin/sh
for count in 128 256 512 1024 2048 4096 8192 16384 32768; do
    echo $count
    for i in $(seq $count); do
	od -vAn -N2 -td2 < /dev/urandom >> RandomIntegers$count.txt
	#echo $SRANDOM >> RandomIntegers$count.txt
    done
done
