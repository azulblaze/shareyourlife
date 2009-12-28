// JavaScript Document
function Set() {  
    this.values = new Array();        
    this.put = function(value) {  
        for(var i=0;i<this.values.length;i++){
			if(this.values[i]==value){
				return false;
			}
		}
		this.values.push(value);
		return true;
    };
    this.clear = function(){
    	this.values = new Array();
    }
    this.remove = function(value) {
		for(var i=0;i<this.values.length;i++){
			if(this.values[i]==value){
				this.values.splice(i,1);
				return true;
			}
		}
    };
    this.isEmpty = function() {
        return (this.values.length == 0);  
    };
	this.contains = function(value){
		for(var i=0;i<this.values.length;i++){
			if(this.values[i]==value){
				return true;
			}
		}
		return false;
	}
    this.size = function(){
        return this.values.length;  
    };
	this.toString = function(){
		return this.values.toString();
    }
}  