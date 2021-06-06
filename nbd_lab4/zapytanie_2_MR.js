var mapper = function() {
	this.credit.forEach(function(credit){
		emit(credit.currency, parseFloat(credit.balance)); 
	});
};

var reducer = function(key, value) {
	return (key, Array.sum(value))
};

printjson(db.people.mapReduce(mapper, reducer, { out: {inline: 1} }))