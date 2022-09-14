//Negativne testy v regionoch
$(document).ready(function(){
    $.ajax({
        url: "http://localhost:8080/api/regionAgTests/PositiveRegionTests",
        method: "GET",
        success: function(data) {
            var correctData = [];
            var title = [];
            var positive = [];

            for(var i in data) {
                for(var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            for(var i in correctData) {
                if (i%2 !== 0){
                    positive.push(correctData[i]);
                }else title.push(correctData[i]);
            }

            var chartdata = {
                labels: title,
                datasets : [
                    {
                        label: 'Počet pozitívnych testov v krajoch od začiatku pandémie.',
                        backgroundColor: 'rgba(200, 200, 200, 0.75)',
                        borderColor: 'rgba(200, 200, 200, 0.75)',
                        hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: positive
                    }
                ]
            };

            var ctx = $("#positiveRegionTests");

            var barGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata
            });
        },
        error: function(data) {
            console.log(data);
        }
    });
});

//----------------------------------------------------------------------------------------
//Počet negatívnych testov v krajoch
$(document).ready(function(){
    $.ajax({
        url: "http://localhost:8080/api/regionAgTests/NegativeRegionTests",
        method: "GET",
        success: function(data) {
            var correctData = [];
            var title = [];
            var negative = [];

            for(var i in data) {
                for(var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            for(var i in correctData) {
                if (i%2 !== 0){
                    negative.push(correctData[i]);
                }else title.push(correctData[i]);
            }

            var chartdata = {
                labels: title,
                datasets : [
                    {
                        label: 'Počet negatívnych testov v krajoch od začiatku pandémie.',
                        backgroundColor: 'rgba(200, 200, 200, 0.75)',
                        borderColor: 'rgba(200, 200, 200, 0.75)',
                        hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: negative
                    }
                ]
            };

            var ctx = $("#negativeRegionTests");

            var barGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata
            });
        },
        error: function(data) {
            console.log(data);
        }
    });
});
//----------------------------------------------------------------------------------------
//Negitevne vs Pozitivne
$(document).ready(function(){
    $.ajax({
        url: "http://localhost:8080/api/slovakiaAgTests/slovakiaSumAgTests",
        method: "GET",
        success: function(data) {
            var correctData = [];
            var tests = [];

            for(var i in data) {
                for(var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            for(var i in correctData) {
                    tests.push(correctData[i]);
            }

            var chartdata = {
                labels: ["Negatívne testy","Pozitívne testy"],
                datasets : [
                    {
                        label: 'Počet negatívnych testov a počet pozitývnych testov.',
                        backgroundColor: ['rgba(200, 100, 200, 0.75)','rgba(100, 200, 200, 0.75)'],
                        borderColor: 'rgba(200, 200, 200, 0.75)',
                        hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: tests
                    }
                ]
            };

            var ctx = $("#positiveVsNegative");

            var barGraph = new Chart(ctx, {
                type: 'pie',
                data: chartdata
            });
        },
        error: function(data) {
            console.log(data);
        }
    });
});

//----------------------------------------------------------------------------------------
//positivity_rate za posledne 2 roky
$(document).ready(function(){
    $.ajax({
        url: "http://localhost:8080/api/slovakiaAgTests/avgPosRate",
        method: "GET",
        success: function(data) {
            var correctData = [];
            var rate = [];
            var month = [];
            for(var i in data) {
                for(var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }
            var indexOfrate = 2;
            var indexOfmonth = 1;
            var x = 0;
            with (x === 24) {
                rate.push(correctData[indexOfrate]);
                month.push(correctData[indexOfmonth]);
                3 + indexOfrate;
                indexOfmonth++;
                x++;
            }

            console.log(month)

            var chartdata = {
                labels: month,
                datasets : [
                    {
                        label: 'Počet negatívnych testov a počet pozitývnych testov.',
                        backgroundColor: ['rgba(200, 100, 200, 0.75)','rgba(100, 200, 200, 0.75)'],
                        borderColor: 'rgba(200, 200, 200, 0.75)',
                        hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: rate
                    }
                ]
            };

            var ctx = $("#positivity_rate");

            var barGraph = new Chart(ctx, {
                type: 'line',
                data: chartdata
            });
        },
        error: function(data) {
            console.log(data);
        }
    });
});


