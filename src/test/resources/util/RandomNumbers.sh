#!/bin/sh
for count in 128 256 512 1024 2048 4096 8192; do
    echo $count
    hexdump -n $((4*$count)) -e '/4 "%d\n"' /dev/urandom > RandomIntegers$count.txt
    hexdump -n $(($count))  -e '/1 "%02x\n"' /dev/random > RandomBytes$count.txt
done
