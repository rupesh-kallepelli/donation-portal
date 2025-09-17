interface TextBoxProps {
    placeholder?: string;
    inputLength?: number;
    className?: string;
    type?: string;
}

const TextBox: React.FC<TextBoxProps> = ({placeholder, inputLength, className, type}) => {
    return (
    <>
        <div>
            <input className={className} type={type} placeholder={placeholder} size={inputLength}/>
        </div>
    </>);
}
export default TextBox;