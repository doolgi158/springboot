document.getElementById("updateFormBtn").addEventListener("click", function() {
    formSubmit("dataForm", "post", "/board/updateForm");
});

document.getElementById("boardDeleteBtn").addEventListener("click", function() {
    if(confirm("정말 삭제하겠습니까?")) {
        formSubmit("dataForm", "post", "/board/boardDelete");
    }
})