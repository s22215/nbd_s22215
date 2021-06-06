printjson(db.people.aggregate([
	{ $unwind : "$credit" },
	{$project:{
		"balance": {$toDouble: "$credit.balance"},
		"currency": "$credit.currency"
	}},
	{$group: {
		_id: "$currency",
		currency_sum: {$sum: "$balance"}
	}}
]).toArray())