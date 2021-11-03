export type Interview = {
    id: number,
    interviewDatetime: string,
    appId: number,
    answersOnQuestions: any,

    aspects: Aspects
}

export type Aspects = {
    aggressiveness: number,
    politeness: number,
    authority: number,
    manipulativeness: number,
    specifics: number,
    brevity: number
}

export const aspectsWithi18nColor  = {
    aggressiveness: {name: 'Враждебность', color: 'danger'},
    politeness: {name: 'Вежливость', color: 'success'},
    authority: {name: 'Авторитетность', color: 'info'},
    manipulativeness: {name: 'Манипулятивность', color: 'warning'},
    specifics: {name: 'Конкретика', color: 'success'},
    brevity: {name: 'Лаконичность', color: 'info'},
}

