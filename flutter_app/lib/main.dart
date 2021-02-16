import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: Text("AppBar"),
        backgroundColor: Colors.cyanAccent[700],
      ),
      backgroundColor: Colors.blueGrey[700],
      body: Center(
        child: Image(
          image: AssetImage('images/diamond.png'),
        ),
      ),
    ),
  ));
}
