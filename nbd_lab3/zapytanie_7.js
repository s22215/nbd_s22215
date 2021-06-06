printjson(db.people.remove(
	{$where: "parseFloat(this.height) > 190.0"},
	{"justOne": false}
))