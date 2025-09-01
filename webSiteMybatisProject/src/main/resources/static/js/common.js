function chkData(itemSelector, outSelector, msg) {
    const out = document.querySelector(outSelector);
    const element = document.querySelector(itemSelector);
    const value = element.value.trim();

    if(value === "") {
        out.textContent = `${message} 입력해 주세요.`;
        element.value = "";
        element.focus();
        return false;
    }
    return true;
}

const formSubmit = (selector, method, action) => {
    const form = document.getElementById(selector);
    form.method = method;
    form.action = action;
    form.submit();
}

const formReset = (selector) => {
    const form = document.getElementById(selector);
    form.reset();
}

const locationProcess = (url) => {
    location.href = url;
}