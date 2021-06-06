var mapper = function() {
	if (this.sex=="Male"){
		emit("Average_male_height", parseFloat(this.height));
		emit("Average_male_weight", parseFloat(this.weight))
	} 
	
	if (this.sex=="Female"){
		emit("Average_female_height", parseFloat(this.height));
		emit("Average_female_weight", parseFloat(this.weight))
	} 
};

var reducer = function(key, value) {
	return (key, Array.concat(value))
};

var finalize1 = function(key, value) {
	return (key, Array.sum(value)/value.length)
}

printjson(db.people.mapReduce(mapper, reducer, { out: {inline: 1}, finalize:finalize1 }))