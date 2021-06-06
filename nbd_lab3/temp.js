printjson(db.people.find(
	{$where: "parseFloat(this.height) > 190.0"}
).toArray())