#!/bin/bash

N=1000
P=2

if [ ! -f "multiply_seq" ]
then
    echo "Nu exista binarul multiply_seq"
    exit
fi

if [ ! -f "multiply" ]
then
    echo "Nu exista binarul multiply"
    exit
fi

if [ ! -f "multiply2" ]
then
    echo "Nu exista binarul multiply2"
    exit
fi

if [ ! -f "multiply3" ]
then
    echo "Nu exista binarul multiply3"
    exit
fi

if [ ! -f "strassen" ]
then
    echo "Nu exista binarul strassen"
    exit
fi

if [ ! -f "strassen2" ]
then
    echo "Nu exista binarul strassen2"
    exit
fi

./multiply_seq $N > seq.txt
./multiply $N $P > par.txt
./multiply2 $N $P > par2.txt
./multiply3 $N $P > par3.txt

./strassen 1500 > seq2.txt
./strassen2 1500 > par4.txt

diff seq.txt par.txt
diff seq.txt par2.txt
diff seq.txt par3.txt
diff seq2.txt par4.txt

rm -rf seq.txt seq2.txt par.txt par2.txt par3.txt par4.txt