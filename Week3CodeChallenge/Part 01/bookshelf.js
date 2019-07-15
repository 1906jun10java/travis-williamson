let atlas_shrugged_cover = new Image();
img.src = "atlas_shrugged_book_cover.jpg";


let books = {
    atlas_shrugged: {
        title: "Atlas Shrugged",
        author: "Ayn Rand",
        genre: "Science Fiction",
        cover: atlas_shrugged_cover
    }
}

let createBook = function(title, author, genre, cover) {
    let book;
    book.title = title;
    book.author = author;
    book.genre = genre;
    book.cover = cover

    books.push(book);
}

let bookshelf = document.createElement("TABLE");

let display_book_info = function() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
}

let list = function(books) {
    for (let book in books) {
        document.getElementById('bookshelf').innerHTML += '<li>' + book + '</li>';
        console.log(book);
    }
}