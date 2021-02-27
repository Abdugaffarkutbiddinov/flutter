import 'package:davlatlar/screens/country.dart';
import 'package:dio/dio.dart';
import 'package:flutter/material.dart';

class AllCountries extends StatefulWidget {
  @override
  _AllCountriesState createState() => _AllCountriesState();
}

class _AllCountriesState extends State<AllCountries> {
  List countries = [];
  List filteredCountries = [];
  bool isSearching = false;
  getAllCountries() async {
    var response = await Dio().get('https://restcountries.eu/rest/v2/all');
    return response.data;
  }

  @override
  void initState() {
    getAllCountries().then((data) {
      setState(() {
        countries = filteredCountries = data;
      });
    });
    {}
    // TODO: implement initState
    super.initState();
  }

  void _filterCountries(value) {
    setState(() {
      filteredCountries = countries
          .where((country) =>
              country['name'].toLowerCase().contains(value.toLowerCase()))
          .toList();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.cyan[100],
      appBar: AppBar(
        backgroundColor: Colors.cyan,
        title: !isSearching
            ? Text('Countries')
            : TextField(
                onChanged: (value) {
                  _filterCountries(value);
                },
                decoration: InputDecoration(
                  icon: Icon(
                    Icons.flag,
                    color: Colors.white,
                  ),
                ),
              ),
        actions: <Widget>[
          !isSearching
              ? IconButton(
                  icon: Icon(Icons.search),
                  onPressed: () {
                    setState(() {
                      this.isSearching = true;
                    });
                  })
              : IconButton(
                  icon: Icon(Icons.cancel),
                  onPressed: () {
                    setState(() {
                      this.isSearching = false;
                      filteredCountries = countries;
                    });
                  })
        ],
      ),
      body: Container(
        padding: EdgeInsets.all(3),
        child: filteredCountries.length > 0
            ? ListView.builder(
                itemCount: filteredCountries.length,
                itemBuilder: (
                  BuildContext context,
                  int index,
                ) {
                  return GestureDetector(
                    child: Card(
                      elevation: 10,
                      child: Padding(
                        padding: const EdgeInsets.symmetric(
                            vertical: 15, horizontal: 15),
                        child: Text(
                          filteredCountries[index]['name'],
                        ),
                      ),
                    ),
                    onTap: () {
                      Navigator.pushNamed(context, Country.routeName,
                          arguments: countries[index]);
                    },
                  );
                })
            : Center(
                child: CircularProgressIndicator(),
              ),
      ),
    );
  }
}
