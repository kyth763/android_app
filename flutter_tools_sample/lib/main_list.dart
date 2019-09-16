import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:flutter_tools_sample/generated/i18n.dart';

class ToolsListPage extends StatelessWidget {
  static BuildContext _context;
  @override
  Widget build(BuildContext context) {
    _context = context;
    final title = S.of(context).tools_list_title;
    return MaterialApp(
      title: S.of(context).app_name,
      home: Scaffold(
        appBar: AppBar(title: Text(title),),
        body: ListView(children: listTiles),
      ),
    );
  }

  List<Widget> listTiles = <Widget>[
    Container(
        decoration: new BoxDecoration(
          border: new Border(
            bottom: new BorderSide(color: Colors.black26),
          ),
        ),
        child: ListTile(
          leading: Icon(Icons.map),
          title: Text('Map'),
          onTap: () {openDialog(_context);},
        )
    ),
    Container(
        decoration: new BoxDecoration(
          border: new Border(
            bottom: new BorderSide(color: Colors.black26),
          ),
        ),
        child: ListTile(
          leading: Icon(Icons.photo_album),
          title: Text('Album'),
        )
    ),
    Container(
        decoration: new BoxDecoration(
          border: new Border(
            bottom: new BorderSide(color: Colors.black26),
          ),
        ),
        child: ListTile(
          leading: Icon(Icons.phone),
          title: Text('Phone'),
        )
    ),
  ];


  static void openDialog(BuildContext context) {
    showDialog<Answers>(
      context: context,
      builder: (BuildContext context) => new SimpleDialog(
        title: new Text('SimpleDialog'),
        children: <Widget>[
          createDialogOption(context, Answers.YES, 'Yes'),
          createDialogOption(context, Answers.NO, 'No')
        ],
      ),
    ).then((value) {
      switch(value) {
        case Answers.YES:
          //_setValue('Yes');
          break;
        case Answers.NO:
          //_setValue('No');
          break;
      }
    });
  }

  static createDialogOption(BuildContext context, Answers answer, String str) {
    return new SimpleDialogOption(child: new Text(str),onPressed: (){Navigator.pop(context, answer);},);
  }
}
enum Answers {
  YES,
  NO
}
