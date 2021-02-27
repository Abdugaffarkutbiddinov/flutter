import 'package:davlatlar/screens/CountryMap.dart';
import 'package:dio/dio.dart';
import 'package:flip_card/flip_card.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class Country extends StatelessWidget {
  static const routeName = '/country';

  @override
  Widget build(BuildContext context) {
    final Map _country = ModalRoute.of(context).settings.arguments;
    return Scaffold(
      backgroundColor: Colors.cyan[100],
      appBar: AppBar(
        backgroundColor: Colors.cyan,
        title: Text(_country['name']),
      ),
      body: Container(
        padding: EdgeInsets.all(10),
        child: GridView(
          gridDelegate:
              SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 2),
          children: [
            FlipCard(
                front: CardWidget(
                  title: 'Capital',
                ),
                back: CardDetail(
                  _country['capital'],
                  Colors.deepPurple,
                )),
            FlipCard(
                front: CardWidget(
                  title: 'Population',
                ),
                back: CardDetail(
                    _country['population'].toString(), Colors.orange)),
            FlipCard(
                front: CardWidget(
                  title: 'Currency',
                ),
                back: CardDetail(
                    _country['currencies'][0]['name'], Colors.green)),
            FlipCard(
              front: CardWidget(
                title: 'Flag',
              ),
              back: Card(
                color: Colors.grey.shade200,
                child: Center(
                  child: SvgPicture.network(_country['flag']),
                ),
                elevation: 10,
              ),
            ),
            GestureDetector(
              child: CardWidget(
                title: 'Map',
              ),
              onTap: () {
                Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => CountryMap(),
                    ));
              },
            )
          ],
        ),
      ),
    );
  }
}

class CardDetail extends StatelessWidget {
  final String title;
  final MaterialColor color;
  CardDetail(this.title, this.color);
  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 10,
      color: color,
      child: Center(
          child: Text(
        title,
        style: TextStyle(fontSize: 18),
      )),
    );
  }
}

class CardWidget extends StatelessWidget {
  final String title;
  const CardWidget({
    Key key,
    this.title,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.grey.shade200,
      child: Center(
          child: Text(title,
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold))),
      elevation: 10,
    );
  }
}
