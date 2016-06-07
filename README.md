# pi4watering *** (In progress) ***
pi4j-project. (using java to controll the GPIO-ports on rPi)

Turns your raspberry-pi to a watering-system for flower-pots (indoor).

<b>Inside</b><br/>
Waters every odd day in the morning.<br>
Every even day around 3pm the program checks the weather, if there is less than 50% clouds, it will water that day too.

<b>Balcony</b><br/>
Waters every day in the morning.<br/>
Every day around 3pm the program checks the weather, if there is less than 50% clouds, it will water then too.<br/>
If it's very cloudy three days in a streak, the program will not water that next day<br/>

<h2>Hardware:</h2>
<ul>
<li>
  Raspberry pi
</li>
<li>
  USB WIFI Dongle
</li>
<li>
  2-channel relay
</li>
<li>
  Water-pump 12v motor
</li>
<li>
  Jumper cables
</li>
<li>
  Power-supply 12v
</li>
<li>
  8mm hose
</li>
</ul>

![wiring](https://dl.dropboxusercontent.com/u/6055409/pi4watering.jpg)

<h2>Software:</h2>
<ul>
<li>
  Java
</li>
<li>
  Maven
</li>
<li>
Spring-boot
</li>
<li>
h2 database
</li>
<li>
  HTML
</li>
<li>
  JQuery
</li>
</ul>

Web interface:
![screenshot interface](https://dl.dropboxusercontent.com/u/6055409/pi4watering%20screenshot1.png)

Testing hardware:
![pi4watering](https://dl.dropboxusercontent.com/u/6055409/pi4watering1.JPG)

Hardware running:
![pi4watering](https://dl.dropboxusercontent.com/u/6055409/pi4watering2.JPG)

Built hose holder: 
![pi4watering](https://dl.dropboxusercontent.com/u/6055409/pi4watering3.JPG)

On the balcony: 
![pi4watering](https://dl.dropboxusercontent.com/u/6055409/pi4watering4.JPG)
