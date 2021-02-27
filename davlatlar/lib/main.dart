import 'package:davlatlar/screens/country.dart';
import 'package:flutter/material.dart';
import 'package:davlatlar/screens/AllCountries.dart';

void main() {
  runApp(new MaterialApp(
    home: new AllCountries(),
    routes: {Country.routeName: (ctx) => Country()},
  ));
}
