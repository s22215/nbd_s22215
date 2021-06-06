var mapper = function() {
	var weight = parseFloat(this.weight);
	var height = parseFloat(this.height)/100;
	var bmi = weight / (height*height);
	emit(this.nationality, bmi);
};

var reducer = function(key, value) {	
	return (key, Array.concat(value));
};

var finalize1 = function(key, value) {
	return (key, 
			{'Avg bmi': value.reduce((a, b) => a + b, 0)/value.length, 
			 'Max bmi': Math.max.apply(null, value), 
			 'Min bmi': Math.min.apply(null, value)})
}

printjson(db.people.mapReduce(mapper, reducer, { out: {inline: 1}, finalize:finalize1 }))