var mapper = function() {
	if (this.nationality=="Poland"&&this.sex=="Female"){
		this.credit.forEach(function(credit){
			emit(credit.currency, parseFloat(credit.balance)); 
		});
	}
};

var reducer = function(key, value) {
	return (key, Array.concat(value));
};

var finalize1 = function(key, value) {
	var totalAmount = value.reduce((a, b) => a + b, 0)
	return (key, {'Average amount': totalAmount/value.length, 'Total amount': totalAmount});
}

printjson(db.people.mapReduce(mapper, reducer, { out: {inline: 1}, finalize:finalize1 }))