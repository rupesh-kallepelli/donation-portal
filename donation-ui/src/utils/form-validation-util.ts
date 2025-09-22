const isValidEmail = (email: string): boolean => {
  const strictEmailRegex: RegExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  return strictEmailRegex.test(email);
}
const isValidPassword = (password: string): boolean => {
  const passwordRegex: RegExp = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
  return passwordRegex.test(password);
}
export { isValidEmail, isValidPassword };