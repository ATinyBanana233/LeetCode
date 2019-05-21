#!/bin/bash
makeHeart()
{
  n=$1;

  echo "                                HAPPY 520!"

  for ((a=n/2;a<=n;a+=2))
  do
  	  #This loop print spaces required
      for((b=1;b<n-a;b+=2))
      do
        echo -ne " ";
        sleep 0.001
      done

      for((b=1;b<=a;b++))
      do
        echo -ne "*";
        sleep 0.001
      done

      for((b=1;b<=n-a;b++))
      do
        echo -ne " ";
        sleep 0.001
      done

      for((b=1;b<=a-1;b++))
      do
        echo -ne "*";
        sleep 0.001
      done

      echo

  done

  #outer loop is for printing number of rows in the pyramid
  for((i=n;i>=0;i--))
  do

      #This loop print spaces required
      for((k=0;k<=n-i;k++))
      do
        echo -ne " ";
        sleep 0.001
      done

      #This loop print part1 of the the pyramid
      for((j=1;j<=i-1;j++))
      do
      echo -ne "*";
      sleep 0.001
      done

      #This loop print part 2 of the pryamid.
      for((z=1;z<i-1;z++))
      do
      echo -ne "*";
      sleep 0.001
      done
      
      #This echo used for printing new line
      echo;
  done
}

makeHeart 36

