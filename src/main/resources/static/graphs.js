//Negativne testy v regionoch
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/regionAgTests/PositiveRegionTests",
        method: "GET",
        success: function (data) {
            var correctData = [];
            var title = [];
            var positive = [];

            for (var i in data) {
                for (var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            for (var i in correctData) {
                if (i % 2 !== 0) {
                    positive.push(correctData[i]);
                } else title.push(correctData[i]);
            }

            var chartdata = {
                labels: title,
                datasets: [
                    {
                        label: 'Počet pozitívnych testov v krajoch od začiatku pandémie.',
                        backgroundColor: ['rgba(245, 39, 67, 0.8)','rgba(41, 39, 245, 0.8)',
                                          'rgba(39, 245, 234, 0.8)','rgba(245, 234, 39, 0.8)',
                                          'rgba(245, 148, 39, 0.8)','rgba(238, 39, 245, 0.8)',
                                          'rgba(192, 191, 192, 0.8)','rgba(49, 201, 50, 0.8)'],
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
        error: function (data) {
            console.log(data);
        }
    });
});

//----------------------------------------------------------------------------------------
//Počet negatívnych testov v krajoch
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/regionAgTests/NegativeRegionTests",
        method: "GET",
        success: function (data) {
            var correctData = [];
            var title = [];
            var negative = [];

            for (var i in data) {
                for (var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            for (var i in correctData) {
                if (i % 2 !== 0) {
                    negative.push(correctData[i]);
                } else title.push(correctData[i]);
            }

            var chartdata = {
                labels: title,
                datasets: [
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
        error: function (data) {
            console.log(data);
        }
    });
});
//----------------------------------------------------------------------------------------
//Negitevne vs Pozitivne
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/slovakiaAgTests/slovakiaSumAgTests",
        method: "GET",
        success: function (data) {
            var correctData = [];
            var tests = [];

            for (var i in data) {
                for (var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            for (var i in correctData) {
                tests.push(correctData[i]);
            }

            var chartdata = {
                labels: ["Negatívne testy", "Pozitívne testy"],
                datasets: [
                    {
                        label: 'Počet negatívnych testov a počet pozitývnych testov.',
                        backgroundColor: ['rgba(200, 100, 200, 0.75)', 'rgba(100, 200, 200, 0.75)'],
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
        error: function (data) {
            console.log(data);
        }
    });
});

//----------------------------------------------------------------------------------------
//positivity_rate za posledne 2 roky
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/slovakiaAgTests/avgPosRate",
        method: "GET",
        success: function (data) {
            var correctData = [];
            var rate = [];
            var month = [];
            for (var i in data) {
                for (var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            var indexOfmonth = 1;
            var indexOfrate = 2;
            var x = 0;
            while (x < 24) {
                rate.push(correctData[indexOfrate]);
                switch (correctData[indexOfmonth]) {
                    case 1:
                        month.push("Január");
                        break;
                    case 2:
                        month.push("Február");
                        break;
                    case 3:
                        month.push("Marec");
                        break;
                    case 4:
                        month.push("Aprĺ");
                        break;
                    case 5:
                        month.push("Máj");
                        break;
                    case 6:
                        month.push("Jún");
                        break;
                    case 7:
                        month.push("Júl");
                        break;
                    case 8:
                        month.push("August");
                        break;
                    case 9:
                        month.push("September");
                        break;
                    case 10:
                        month.push("Október");
                        break;
                    case 11:
                        month.push("November");
                        break;
                    case 12:
                        month.push("December");
                        break;
                }
                indexOfrate = indexOfrate + 3;
                indexOfmonth = indexOfmonth + 3;
                x++;
            }

            var chartdata = {
                labels: month,
                datasets: [
                    {
                        label: 'Priemerná miera pozitivity za posledné 2 roky.',
                        backgroundColor: 'rgba(100, 200, 200, 0.75)',
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
        error: function (data) {
            console.log(data);
        }
    });
});

//----------------------------------------------------------------------------------------
//Aktualny počet pacientov v nemocniciach
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/regionHospitalPatients/ActualRegionHospitalPatients",
        method: "GET",
        success: function (data) {
            var correctData = [];
            var title = [];
            var patients = [];

            for (var i in data) {
                for (var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            for (var i in correctData) {
                if (i % 2 !== 0) {
                    patients.push(correctData[i]);
                } else title.push(correctData[i]);
            }

            var chartdata = {
                labels: title,
                datasets: [
                    {
                        label: 'Aktuálny počet pacientov v nemocniciach s ochorením COVID 19.',
                        backgroundColor: 'rgba(200, 200, 200, 0.75)',
                        borderColor: 'rgba(200, 200, 200, 0.75)',
                        hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: patients
                    }
                ]
            };

            var ctx = $("#actualRegionPatients");

            var barGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata
            });
        },
        error: function (data) {
            console.log(data);
        }
    });
});
//----------------------------------------------------------------------------------------
//Zaockovanost
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/regionVaccinations/regDoseVacc",
        method: "GET",
        success: function (data) {
            var correctData = [];
            var title = [];
            var dose1 = [];
            var dose2 = [];

            for (var i in data) {
                for (var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            var indexOfTitle = 0;
            var indexOfDose1 = 1;
            var indexOfDose2 = 2;
            var x = 0;

            while (x < 8){
                title.push(correctData[indexOfTitle]);
                dose1.push(correctData[indexOfDose1]);
                dose2.push(correctData[indexOfDose2]);
                indexOfTitle = indexOfTitle + 3;
                indexOfDose1 = indexOfDose1 + 3;
                indexOfDose2 = indexOfDose2 + 3;
                x++;
            }

            var chartdata = {
                labels: title,
                datasets: [{
                    label: "1. dávka",
                    backgroundColor: "blue",
                    data: dose1
                }, {
                    label: "2. dávka",
                    backgroundColor: "red",
                    data: dose2
                }]
            };
            var ctx = $("#vaccinations");
            var barGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata
            });
        },
        error: function (data) {
            console.log(data);
        }
    });
});

//Cov 19 kapacita
$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/api/regionHospitalBeds/regCovCapacity",
        method: "GET",
        success: function (data) {
            var correctData = [];
            var title = [];
            var capacity = [];

            for (var i in data) {
                for (var j in data[i]) {
                    correctData.push(data[i][j]);
                }
            }

            for (var i in correctData) {
                if (i % 2 !== 0) {
                    capacity.push(correctData[i]);
                } else title.push(correctData[i]);
            }

            var chartdata = {
                labels: title,
                datasets: [
                    {
                        label: 'Počet voľných miest pre ochoronnie covid19.',
                        backgroundColor: ['rgba(245, 39, 67, 0.8)','rgba(41, 39, 245, 0.8)',
                            'rgba(39, 245, 234, 0.8)','rgba(245, 234, 39, 0.8)',
                            'rgba(245, 148, 39, 0.8)','rgba(238, 39, 245, 0.8)',
                            'rgba(192, 191, 192, 0.8)','rgba(49, 201, 50, 0.8)'],
                        borderColor: 'rgba(200, 200, 200, 0.75)',
                        hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                        hoverBorderColor: 'rgba(200, 200, 200, 1)',
                        data: capacity
                    }
                ]
            };

            var ctx = $("#actualRegCapacity");

            var barGraph = new Chart(ctx, {
                type: 'bar',
                data: chartdata
            });
        },
        error: function (data) {
            console.log(data);
        }
    });
});



