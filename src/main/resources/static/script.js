var xmlthttp = new XMLHttpRequest();
var url = "http://localhost:8080/api/cities/ActualDataTestTDO"
xmlthttp.open("GET", url, true)
xmlthttp.send();
xmlthttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        var data = JSON.parse(this.responseText);
        //console.log(data);
        $('#example').DataTable({
            "data": data,
            columns: [
                {data: 'title'},
                {data: 'free_all'},
                {data: 'confirmed_covid'},
                {data: 'non_covid'},
                {data: 'suspected_covid'},

            ],
        });
    }
}


// const searchBar = document.getElementById('searchBar');
// let hpCharacters = [];

// searchBar.addEventListener('keyup', (e) => {
//     const searchString = e.target.value.toLowerCase();
//
//     const filteredCharacters = hpCharacters.filter((character) => {
//         return (
//             character.id.toString().toLowerCase().includes(searchString) ||
//             character.title.toString().toLowerCase().includes(searchString)
//
//
//         );
//     });
//     buildTable(filteredCharacters);
// });

// const loadCharacters = async () => {
//     try {
//         const res = await fetch('http://localhost:8080/api/cities/ActualDataTestTDO');
//         hpCharacters = await res.json();
//         buildTable(hpCharacters);
//     } catch (err) {
//         console.error(err);
//     }
// };
//
// loadCharacters();
// buildTable(hpCharacters)
//
// function buildTable(data){
//     var table = document.getElementById('myTable')
//     table.innerHTML = ''
//     for (var i = 0; i < data.length; i++){
//         var row = `<tr>
//
// 							<td>${data[i].title}</td>
// 							<td>${data[i].free_all}</td>
// 							<td>${data[i].confirmed_covid}</td>
// 							<td>${data[i].non_covid}</td>
// 							<td>${data[i].suspected_covid}</td>
//
// 					  </tr>`
//         table.innerHTML += row
//
//
//     }
// }


// const clearInput = () => {
//     const input = document.getElementsByTagName("input")[0];
//     input.value = "";
// }
//
// const clearBtn = document.getElementById("clear-btn");
// clearBtn.addEventListener("click", clearInput);

// $('th').on('click', function(){
//     var column = $(this).data('column')
//     var order = $(this).data('order')
//     var text = $(this).html()
//     text = text.substring(0, text.length - 1)
//
//     if(order == 'desc'){
//         $(this).data('order', "asc")
//         hpCharacters = hpCharacters.sort((a,b) => a[column] > b[column] ? 1 : -1)
//         text += '&#9660'
//
//     }else{
//         $(this).data('order', "desc")
//         hpCharacters = hpCharacters.sort((a,b) => a[column] < b[column] ? 1 : -1)
//         text += '&#9650'
//
//     }
//     $(this).html(text)
//     buildTable(hpCharacters)
// })





