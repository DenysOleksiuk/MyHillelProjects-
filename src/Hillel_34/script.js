const display = document.getElementById('display');
const buttons = document.querySelectorAll('.btn');

let expression = '';

function updateDisplay() {
    display.value = expression;
}

function isOperator(char) {
    return ['+', '-', '*', '/'].includes(char);
}

buttons.forEach(button => {
    button.addEventListener('click', () => {
        const value = button.getAttribute('data-value');

        if (button.id === 'clear') {
            expression = '';
            updateDisplay();
            return;
        }

        if (button.id === 'backspace') {
            expression = expression.slice(0, -1);
            updateDisplay();
            return;
        }

        if (button.id === 'equals') {
            calculateResult();
            return;
        }


        if (value) {
            if (expression.length === 0 && isOperator(value)) {
                if (value !== '-') return;
            }

            const lastChar = expression.slice(-1);
            if (isOperator(lastChar) && isOperator(value)) {
                expression = expression.slice(0, -1) + value;
            } else {
                expression += value;
            }
            updateDisplay();
        }
    });
});

function calculateResult() {
    if (expression === '') {
        display.value = '';
        return;
    }
    try {
        let trimmedExp = expression;
        while (trimmedExp.length && isOperator(trimmedExp.slice(-1))) {
            trimmedExp = trimmedExp.slice(0, -1);
        }
        if (trimmedExp === '') {
            expression = '';
            updateDisplay();
            return;
        }

        // Виконуємо обчислення
        const result = Function(`'use strict'; return (${trimmedExp})`)();

        if (result === Infinity || result === -Infinity) {
            display.value = 'Error: divide by 0!';
            expression = '';
            return;
        }

        if (isNaN(result)) {
            display.value = 'Error: incorrect val!';
            expression = '';
            return;
        }

        expression = result.toString();
        updateDisplay();

    } catch (e) {
        display.value = 'Error: incorrect val!';
        expression = '';
    }
}
