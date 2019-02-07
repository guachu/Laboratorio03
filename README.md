**Part I - Introduction to threads in JAVA**

Change the beginning with start() to run(). How does the output change? Why?
La diferencia en aplicar el Start o el run es que al aplicar solo en run inicia el thread sin importar los pasos anteriores de la iniciacion
en cambio si se inicia con el Start el thread se va a iniciar completamente cumpliendo el orden de un thread

**Part III - Discussion**

How could the implementation be modified to minimize the number of queries in these cases?
Lo que modificariamos seria agregar un valor global el cual se encargue de llevar el conteo de las ocurrencias y asi cuando llegue al minimo se detengan todos los threads

What new element would this bring to the problem?
El problema seria que no se podria confirmar adecuadamente que el valor que este en esta variable se adecuado.


**Part IV - Performance Evaluation** 

A single thread Time = 112.997

As many threads as processing cores (have the program determine this using the Runtime API). Time: 66.06

As many threads as twice the number of processing cores. Time: 30.015

50 threads Time: 1.958

100 threads Time: 0.941


**1 thread**

![](Images/Imagen1.png)

![](Images/imagen2.png)


**2 threads**

![](Images/imagen3.png)

![](Images/imagen4.png)


**4 threads** 

![](Images/imagen5.png)

![](Images/imagen6.png)


**50 threads** 

![](Images/imagen7.png)

![](Images/imagen8.png)

![](Images/imagen9.png)


**100 threads**

![](Images/imagen10.png)

![](Images/imagen11.png)


**Why is the best performance not achieved with the 500 threads? How is this performance compared when using 200 ?.**

Al momento de realizar la operacion con 500 threads se puede observar que este proceso toma unos cuantos segundos mas que si se realizara con 100, esto se debe a que entre mas hilos se tengan y esta cantidad sea mayor al numero de nucleos disponibles en el sistema operativo, no todos los hilos podran correr de manera paralela, si no que empezaran a ir uno detras del otro, entonces se tiene que ciertos hilos tienen una asignacion determinada por el sitema operativo, pero en donde al haber demasiados hilos, muchos se veran negativamente afectados por la asignacion 'justa' del tiempo de computo y al bajar la cantidad de hilos a 200 se observa este tiempo se ajusta un poco al tiempo de los 100 threads



