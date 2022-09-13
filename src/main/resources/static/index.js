$(document).ready(function(){
    $.ajax({
        url: "http://localhost:8080/api/regionAgTests/regionTests",
        method: "GET",
        success: function(data) {
            console.log(data);

            var title = [];
            var positive = [];

            for(var i in data) {
                for(var j in data[i]) {
                    title.push(data[i][0]);
                    positive.push(data[i][1]);
                }
            }



            var chartdata = {
                labels: title,
                datasets : [
                    {
                        label: 'Pozitivita v regionoch',
                        backgroundColor: 'rgba(200, 200, 200, 0.75)',
                        borderColor: 'rgba(200, 200, 200, 0.75)',
                        hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: positive
                    }
                ]
            };

            var ctx = $("#mycanvas");

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



// const pg = require('pg');
//
// const cs = "postgres://postgres:postgres@localhost:5432/coronastudio";
//
// const client = new pg.Client(cs);
//
// client.connect();
//
// const test = [];
// const title = [];
//
// client.query('SELECT sum(r.positives_sum) AS test, r2.title FROM region_ag_tests r inner join regions r2 on r2.id = r.regions_id GROUP BY regions_id, r2.title')
//     .then(res => {
//     const data = res.rows;
//
//     data.forEach(row => {
//         console.log(`test: ${row.test} tite: ${row.title}`);
//         test.push(row.test);
//         title.push(row.title);
//     })
//         console.log(test);
//         console.log(title);
//
// }).finally(() => {
//     client.end()
// });





