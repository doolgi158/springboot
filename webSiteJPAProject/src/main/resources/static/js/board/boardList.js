// 페이징 처리
document.querySelectorAll(".page-item a").forEach(function(element) {
    element.addEventListener("click", function(e) {
        e.preventDefault();
        const pageNumber = this.dataset.number;
        document.getElementById("page").value = pageNumber;
        formSubmit("searchForm", "get", "/board/boardList");
    });
});